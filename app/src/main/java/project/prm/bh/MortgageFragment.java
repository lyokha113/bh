package project.prm.bh;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class MortgageFragment extends Fragment {

    View mortageProcess, inputMortgage, departmentMortgage;

    public MortgageFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mortgage, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        mortageProcess = getActivity().findViewById(R.id.mortageProcess);
        mortageProcess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MontgageProcessActivity.class);
                startActivity(intent);
            }
        });

        inputMortgage = getActivity().findViewById(R.id.inputMortgage);
        inputMortgage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), InputMontgageActivity.class);
                startActivity(intent);
            }
        });


        departmentMortgage = getActivity().findViewById(R.id.mortgageDepartment);
        departmentMortgage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DepartmentActivity.class);
                startActivity(intent);
            }
        });
    }

}
