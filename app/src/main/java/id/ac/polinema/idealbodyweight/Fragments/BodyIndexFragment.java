package id.ac.polinema.idealbodyweight.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import id.ac.polinema.idealbodyweight.R;
import id.ac.polinema.idealbodyweight.Util.BodyMassIndex;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BodyIndexFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class BodyIndexFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    public BodyIndexFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_body_index, container, false);
        final EditText textMass = view.findViewById(R.id.input_mass);
        final EditText textHeight = view.findViewById(R.id.input_height);
        Button calculateButton = view.findViewById(R.id.button_Calculate);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mListener != null){
                    String mass = textMass.getText().toString();
                    String height = textHeight.getText().toString();
                    if (!TextUtils.isEmpty(height) && !TextUtils.isEmpty(mass))
                    {
                        float Mass = Float.parseFloat(mass);
                        float Height = Float.parseFloat(height);
                        BodyMassIndex BMI = new BodyMassIndex(Mass,Height/100);
                        mListener.onCalculateBodyMassIndexClicked(BMI.range());
                    }
                    else{
                        Toast.makeText(getActivity(),"please fill the form",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });return view;
    }

    // TODO: Rename method, update argument and hook method into UI event


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onCalculateBodyMassIndexClicked(String index);
    }
}
