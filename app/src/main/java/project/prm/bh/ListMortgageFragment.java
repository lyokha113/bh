package project.prm.bh;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.card.MaterialCardView;

import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListMortgageFragment extends Fragment {

    private MaterialCardView listMortgageCard1, listMortgageCard2, listMortgageCard3, listMortgageCard4, listMortgageCard5;
    private View selectedCard;

    public ListMortgageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_mortgage, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        listMortgageCard1 = getActivity().findViewById(R.id.listMortgageCard1);
        listMortgageCard2 = getActivity().findViewById(R.id.listMortgageCard2);
        listMortgageCard3 = getActivity().findViewById(R.id.listMortgageCard3);
        listMortgageCard4 = getActivity().findViewById(R.id.listMortgageCard4);
        listMortgageCard5 = getActivity().findViewById(R.id.listMortgageCard5);
    }


//    @Override
//    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
//        super.onCreateContextMenu(menu, v, menuInfo);
//        selectedCard = v;
//        menu.add(0, v.getId(), 0, "Tra cứu");
//        menu.add(0, v.getId(), 0, "Xoá thẻ");
//
//    }
//
//    @Override
//    public boolean onContextItemSelected(MenuItem item) {
//        if (getUserVisibleHint()) {
//            if (item.getTitle().equals("Tra cứu")) {
//            Intent intent = new Intent(getActivity(), ShieldResultActivity.class);
//            startActivity(intent);
//            } else if (item.getTitle().equals("Xoá thẻ")) {
//                selectedCard.setVisibility(View.GONE);
//            } else {
//                return false;
//            }
//            return super.onContextItemSelected(item);
//        }
//
//        return true;
//    }
//
//    @Override
//    public void onResume() {
//        super.onResume();
//        registerForContextMenu(listMortgageCard1);
//        registerForContextMenu(listMortgageCard2);
//        registerForContextMenu(listMortgageCard3);
//        registerForContextMenu(listMortgageCard4);
//        registerForContextMenu(listMortgageCard5);
//    }
//
//    @Override
//    public void onPause() {
//        unregisterForContextMenu(listMortgageCard1);
//        unregisterForContextMenu(listMortgageCard2);
//        unregisterForContextMenu(listMortgageCard3);
//        unregisterForContextMenu(listMortgageCard4);
//        unregisterForContextMenu(listMortgageCard5);
//        super.onPause();
//    }
}
