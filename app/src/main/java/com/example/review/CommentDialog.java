package com.example.review;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by jesmond on 21/9/2016.
 */
public class CommentDialog extends DialogFragment {

    public static CommentDialog newInstance(String title) {
        CommentDialog frag = new CommentDialog();
        Bundle args = new Bundle();
        args.putString("title", title);
        frag.setArguments(args);
        return frag;
    }
    
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        String title = getArguments().getString("title");

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_comment, null);

        TextView titleName = (TextView) view.findViewById(R.id.comment_dialog_title);
        titleName.setText(title);

        Button doneBtn = (Button) view.findViewById(R.id.comment_dialog_done);
        doneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        builder.setView(view);

        Dialog dialog = builder.create();
        return dialog;
    }
}
