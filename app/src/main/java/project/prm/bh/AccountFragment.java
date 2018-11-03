package project.prm.bh;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

public class AccountFragment extends Fragment {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    public AccountFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_account, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        viewPager = getActivity().findViewById(R.id.accountviewpager);
        setupViewPager(viewPager);

        tabLayout = getActivity().findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
        adapter.addFrag(new ListMortgageFragment(), "BHXH");
        adapter.addFrag(new ListShieldFragment(), "BHYT");
        adapter.addFrag(new SupportFragment(), "LIÊN HỆ");
        viewPager.setAdapter(adapter);
    }
}
