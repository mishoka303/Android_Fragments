package com.example.zad3_fragments;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.DialogFragment;

public class FragmentDialog extends DialogFragment implements View.OnClickListener {
    private EditText nameText;
    private EditText addressText;
    private EditText urlText;
    private DialogListener listener;

    public static FragmentDialog newInstance() { return new FragmentDialog(); }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.new_contact1,container,false);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        nameText = view.findViewById(R.id.nameInput);
        addressText = view.findViewById(R.id.addressInput);
        urlText = view.findViewById(R.id.urlInput);
        Button button = view.findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void onAttach(@NonNull Context context)
    {
        super.onAttach(context);
        listener = (DialogListener) context;
    }

    @Override
    public void onClick(View v) {
        Contact contact = new Contact();
        contact.setName(nameText.getText().toString());
        contact.setAddress(addressText.getText().toString());
        contact.setUrl(urlText.getText().toString());
        listener.onFinishAddDialog(contact);
        v.clearFocus();
        v.setFocusable(false);
        dismiss();
    }
}
