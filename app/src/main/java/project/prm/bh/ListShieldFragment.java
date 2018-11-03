package project.prm.bh;


import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.card.MaterialCardView;

import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListShieldFragment extends Fragment {

    private MaterialCardView listShieldCard1, listShieldCard2, listShieldCard3, listShieldCard4, listShieldCard5;
    private View selectedCard;

    public ListShieldFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_shield, container, false);
    }


    @Override
    public void onStart() {
        super.onStart();
        listShieldCard1 = getActivity().findViewById(R.id.listShieldCard1);
        listShieldCard2 = getActivity().findViewById(R.id.listShieldCard2);
        listShieldCard3 = getActivity().findViewById(R.id.listShieldCard3);
        listShieldCard4 = getActivity().findViewById(R.id.listShieldCard4);
        listShieldCard5 = getActivity().findViewById(R.id.listShieldCard5);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        selectedCard = v;
        menu.add(0, v.getId(), 0, "Tra cứu");
        menu.add(0, v.getId(), 0, "Xoá thẻ");

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        if (item.getTitle().equals("Tra cứu")) {
            Intent intent = new Intent(getActivity(), ShieldResultActivity.class);
            startActivity(intent);
        } else if (item.getTitle().equals("Xoá thẻ")) {
            selectedCard.setVisibility(View.GONE);
        } else {
            return false;
        }

        return true;
    }

    @Override
    public void onResume() {
        super.onResume();
        registerForContextMenu(listShieldCard1);
        registerForContextMenu(listShieldCard2);
        registerForContextMenu(listShieldCard3);
        registerForContextMenu(listShieldCard4);
        registerForContextMenu(listShieldCard5);
    }

    @Override
    public void onPause() {
        unregisterForContextMenu(listShieldCard1);
        unregisterForContextMenu(listShieldCard2);
        unregisterForContextMenu(listShieldCard3);
        unregisterForContextMenu(listShieldCard4);
        unregisterForContextMenu(listShieldCard5);
        super.onPause();
    }
}
