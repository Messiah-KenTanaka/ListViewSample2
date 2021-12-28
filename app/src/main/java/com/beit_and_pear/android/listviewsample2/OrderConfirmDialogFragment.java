package com.beit_and_pear.android.listviewsample2;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class OrderConfirmDialogFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // ダイアログビルダーを生成
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // ダイアログタイトルを設定
        builder.setTitle(R.string.dialog_title);
        // ダイアログのメッセージを設定
        builder.setMessage(R.string.dialog_msg);
        // Positive Buttonを設定
        builder.setPositiveButton(R.string.dialog_btn_ok, new DialogButtonClickListener());
        // Negative Button を設定
        builder.setNegativeButton(R.string.dialog_btn_ng, new DialogButtonClickListener());
        // Neutral Button を設定
        builder.setNeutralButton(R.string.dialog_btn_nu, new DialogButtonClickListener());
        // ダイアログオブジェクトを生成し、リターン
        AlertDialog dialog = builder.create();
        return dialog;
    }

    private class DialogButtonClickListener implements DialogInterface.OnClickListener {

        @Override
        public void onClick(DialogInterface dialog, int which) {
            // トーストのメッセージ用文字列変数を用意
            String msg = "";
            // タップされたアクションボタンで分岐
            switch (which) {
                // Positive Buttonならば
                case DialogInterface.BUTTON_POSITIVE:
                    // 注文用のメッセージを格納
                    msg = getString(R.string.dialog_ok_toast);
                    break;
                // Negative Button ならば
                case DialogInterface.BUTTON_NEGATIVE:
                    // キャンセル用のメッセージを格納
                    msg = getString(R.string.dialog_ng_toast);
                    break;
                // Neutral Button ならば
                case DialogInterface.BUTTON_NEUTRAL:
                    // 問い合わせ用のメッセージを格納
                    msg = getString(R.string.dialog_nu_toast);
                    break;
            }
            // トーストを表示
            Toast.makeText(getActivity(), msg, Toast.LENGTH_LONG).show();
        }
    }
}
