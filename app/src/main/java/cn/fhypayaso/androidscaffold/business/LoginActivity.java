package cn.fhypayaso.androidscaffold.business;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.fhypayaso.androidscaffold.R;
import cn.fhypayaso.androidscaffold.base.activity.BaseNoBarActivity;
import cn.fhypayaso.androidscaffold.common.CacheKey;
import cn.fhypayaso.androidscaffold.utils.CacheUtil;
import cn.fhypayaso.androidscaffold.utils.ToastUtil;

public class LoginActivity extends BaseNoBarActivity {


    @BindView(R.id.edt_account)
    EditText mEdtAccount;
    @BindView(R.id.edt_pwd)
    EditText mEdtPwd;
    @BindView(R.id.btn_login)
    Button mBtnLogin;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
    }

    @Override
    protected void initView() {
        //判断是否有登录记录
        String token = CacheUtil.getSP().getString(CacheKey.TOKEN, "");
        if (!"".equals(token)) {
            startActivity(MainActivity.class);
            finish();
        }
    }

    @OnClick({R.id.btn_login})
    public void toLogin(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                showProgressDialog();
                String account = mEdtAccount.getText().toString();
                String pwd = mEdtPwd.getText().toString();
                login(account, pwd);
                break;
        }
    }

    /**
     * 登录请求函数
     *
     * @param account 账号
     * @param pwd     密码
     */
    public void login(String account, String pwd) {
        onLoginSuccess();
//        NetworkFactory.getService().login().enqueue(new ResponseCallBack<ApiResponse<String>>() {
//            @Override
//            public void onDataResponse(Call<ApiResponse<String>> call, Response<ApiResponse<String>> response) {
//
//            }
//
//            @Override
//            public void onDataFailure(Call<ApiResponse<String>> call, Throwable t) {
//
//            }
//        });
    }

    public void onLoginSuccess() {
        dismissProgressDialog();
        startActivity(MainActivity.class);
        finish();
        ToastUtil.showToast("登录成功");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
