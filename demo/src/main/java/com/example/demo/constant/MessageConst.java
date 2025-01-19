package com.example.demo.constant;

/**
 * エラーメッセージID定数クラス
 */

public class MessageConst {
    /** ログイン画面の入力誤り */
    public static final String FORM_ERROR = "common.formError";

    /** ログイン画面：入力内容誤り */
    public static final String LOGIN_WRONG_INPUT = "login.wrongInput";

    /** ユーザー登録画面：既に登録されているログインID */
    public static final String SIGNUP_EXISTED_LOGIN_ID = "signup.existedLoginId";

    /** ユーザー登録画面：ユーザー登録完了 */
    public static final String SIGNUP_RESIST_SUCCEED = "signup.resistSucceed";

    /** ユーザー一覧画面：存在しないログインID */
	public static final String USERLIST_NON_EXISTED_LOGIN_ID = "userList.nonExistedLoginId";

	/** ユーザー一覧画面：ユーザー削除完了 */
	public static final String USERLIST_DELETE_SUCCEED = "userList.deleteSucceed";

	/** ユーザー一覧画面：ユーザー削除完了 */
	public static final String USEREDIT_NON_EXISTED_LOGIN_ID = "userEdit.nonExistedLoginId";

    /** ユーザー情報編集画面：ユーザー更新失敗 */
	public static final String USEREDIT_UPDATE_FAILED = "userEdit.updateFailed";

	/** ユーザー情報編集画面：ユーザー更新完了 */
	public static final String USEREDIT_UPDATE_SUCCEED = "userEdit.updateSucceed";
}
