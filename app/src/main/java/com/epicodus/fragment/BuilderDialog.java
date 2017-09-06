package com.epicodus.fragment;


import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

//To learn how to create a builder dialog see this link
// https://www.learnhowtoprogram.com/android/user-interface-basics-637d41b1-35dc-400a-bcc3-65794760474d/optional-further-exploration-using-a-builder-class-to-create-a-dialog

public class BuilderDialog extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Builder Fragment");
        builder.setMessage("Would you like to take a survey?");

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(), "You answered YES", Toast.LENGTH_LONG).show();
                dismiss();
                FragmentManager fm = getFragmentManager();
                MoodDialogFragment moodDialogFragment = new MoodDialogFragment();
                moodDialogFragment.show(fm, "Sample Fragment");
            }
        });

        builder.setNegativeButton("Nope", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(), "You answered NOPE", Toast.LENGTH_LONG).show();
                dismiss();
            }
        });

        return builder.create();
    }

}