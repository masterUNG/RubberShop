package amon.pramhathai.sasiporn.rmutsv.ac.th.rubbershop.fragment;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import amon.pramhathai.sasiporn.rmutsv.ac.th.rubbershop.OwnerActivity;
import amon.pramhathai.sasiporn.rmutsv.ac.th.rubbershop.R;

/**
 * Created by DR-PC61059 on 9/2/2561.
 */

public class SheetRubberFragment extends Fragment {

    private String[] loginStrings;

    public static SheetRubberFragment sheetRubberFragment(String[] loginStrings) {
        SheetRubberFragment sheetRubberFragment = new SheetRubberFragment();
        Bundle bundle = new Bundle();
        bundle.putStringArray("Login",loginStrings);
        sheetRubberFragment.setArguments(bundle);
        return sheetRubberFragment;
    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        loginStrings = getArguments().getStringArray("Login");

        //create toolbar
        createToolbar();


    }   //main Method

    private void createToolbar() {
        Toolbar toolbar = getView().findViewById(R.id.toolbarSheetRubber);

        ((OwnerActivity)getActivity()).setSupportActionBar(toolbar);

        ((OwnerActivity) getActivity()).getSupportActionBar().setTitle(getString(R.string.sheet_rubber));
        ((OwnerActivity) getActivity()).getSupportActionBar().setSubtitle(getString(R.string.user_login) + loginStrings[1]);

        ((OwnerActivity) getActivity()).getSupportActionBar().setHomeButtonEnabled(true);
        ((OwnerActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });

        setHasOptionsMenu(true);

    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_buy_rubber_sheet, container, false);
        return view;
    }
}
