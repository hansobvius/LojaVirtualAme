package com.android.lodjinhaproject.utils;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.lodjinhaproject.R;

public class DialogMessage extends DialogFragment {

    private TextView mOkButton;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                                Bundle savedInstanceState){

        View rootView = inflater.inflate(R.layout.dialog_fragment, container, false);
        mOkButton = rootView.findViewById(R.id.button_ok);
        initListener();
        return rootView;
    }

    private void initListener(){
        mOkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }
}
