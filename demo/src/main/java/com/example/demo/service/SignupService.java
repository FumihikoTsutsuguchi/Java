package com.example.demo.service;

import java.util.Optional;

import org.dozer.Mapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.constant.AuthorityKind;
import com.example.demo.entity.UserInfo;
import com.example.demo.form.SignupForm;
import com.example.demo.repository.UserInfoRepository;

import lombok.RequiredArgsConstructor;

/**
 * ユーザー登録 Service
 */
@Service
@RequiredArgsConstructor
public class SignupService {

    /** ユーザー情報テーブル DAO */
    private final UserInfoRepository repository;

    /** Dozer Mapper */
    private final Mapper mapper;

    /* PasswordEncoder */
    private final PasswordEncoder passwordEncoder;

    /**
     * ユーザ情報テーブル 主キー検索
     *
     * @param form 入力情報
     * @return 登録情報(ユーザー情報Entity,既に同じユーザーIDで登録がある場合はEmpty)
     */
    public Optional<UserInfo> registerUserInfo(SignupForm form) {
        var userInfoExistedOpt = repository.findById(form.getLoginId());

        if (userInfoExistedOpt.isPresent()) {
            return Optional.empty();
        }

        var userInfo = mapper.map(form, UserInfo.class);

        var encodePassword = passwordEncoder.encode(form.getPassword());
        userInfo.setPassword(encodePassword);
        userInfo.setAuthority(AuthorityKind.ITEM_WATCHER.getAuthorityKind());

        return Optional.of(repository.save(userInfo));
    }
}