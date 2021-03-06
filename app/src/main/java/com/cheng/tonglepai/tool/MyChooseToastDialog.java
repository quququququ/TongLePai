package com.cheng.tonglepai.tool;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.cheng.tonglepai.R;


public class MyChooseToastDialog extends Dialog {

	private static MyChooseToastDialog myToastDialog = null;
	public MyChooseToastDialog progressDialog;

	public MyChooseToastDialog(Context context) {
		super(context);
	}

	public MyChooseToastDialog(Context context, int theme) {
		super(context, theme);
	}

	public static MyChooseToastDialog createDialog(Context context) {
		myToastDialog = new MyChooseToastDialog(context, R.style.CustomProgressDialog);
		myToastDialog.setContentView(R.layout.dialog_showchoosedialog);
		myToastDialog.getWindow().getAttributes().gravity = Gravity.CENTER;
		TextView btn_cancel = (TextView) myToastDialog.findViewById(R.id.btn_cancel);
		btn_cancel.setOnClickListener(new android.view.View.OnClickListener() {
			@Override
			public void onClick(View v) {
				myToastDialog.dismiss();
			}
		});

		return myToastDialog;
	}

	public MyChooseToastDialog setMessage(String strMessage) {
		TextView message = (TextView) myToastDialog.findViewById(R.id.message);

		if (message != null) {
			message.setText(strMessage);
		}

		return myToastDialog;
	}

	public MyChooseToastDialog setTitleShow(String strTitle) {
		TextView title = (TextView) myToastDialog.findViewById(R.id.title);

		if (!TextUtils.isEmpty(strTitle)) {
			title.setText(strTitle);
			title.setVisibility(View.VISIBLE);
		}else{
			title.setVisibility(View.GONE);
		}

		return myToastDialog;
	}

	public MyChooseToastDialog setOnClickListener(android.view.View.OnClickListener listener) {
		TextView btn_ok = (TextView) myToastDialog.findViewById(R.id.btn_ok);
		btn_ok.setOnClickListener(listener);

		return myToastDialog;
	}
}
