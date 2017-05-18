package example.haim.menusanddialogscont;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends DialogFragment {

    Button btnSignIn, btnCancel;
    EditText etUserName, etPassword;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setCancelable(false);
        View v = inflater.inflate(R.layout.fragment_login, container, false);

        return v;
    }

    @Override
    public void onViewCreated(View v, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(v, savedInstanceState);
        btnCancel = (Button) v.findViewById(R.id.btnCancel);
        btnSignIn = (Button) v.findViewById(R.id.btnSignIn);

        etPassword = (EditText) v.findViewById(R.id.etPassword);
        etUserName = (EditText) v.findViewById(R.id.etUserName);

        btnCancel.setOnClickListener(cancelListener);
        btnSignIn.setOnClickListener(signInListener);

    }
        View.OnClickListener cancelListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        };

        View.OnClickListener signInListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etUserName.getText().length() <= 4){
                    etUserName.setError("Must be at least 3 chars");
                    return;
                 }
                Toast.makeText(getActivity(),etUserName.getText()+ " User Created", Toast.LENGTH_LONG).show();
                dismiss();
            }
        };


}
