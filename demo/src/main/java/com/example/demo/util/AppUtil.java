package com.example.demo.util;

import java.util.Locale;

import org.springframework.context.MessageSource;

/**
 * アプリケーション共通クラス
 */

public class AppUtil {

    /**
     * メッセージIDからメッセージを取得
     *
     * @param messageSource メッセージソース
     * @param key メッセージキー
     * @param params 置換文字群
     * @return メッセージ
     */

    public static String getMessage(MessageSource messageSource,String key,Object...params){
        return messageSource.getMessage(key, params, Locale.JAPAN);
    }

    /**
	 * DBのLIKE検索用に、パラメーターにワイルドカードを付与します。
	 *
	 * @param param パラメーター
	 * @return 前後にワイルドカードが付いたパラメーター
	 */
	public static String addWildcard(String param) {
		return "%" + param + "%";
	}

    /**
     * リダイレクト先の先のURLを受け取って、リダイレクトURLを作成します。
     *
     * @param url リダイレクト先
     * @return リダイレクトURL
     */
    public static String doRedirect(String url) {
        return "redirect:" + url;
    }

}
