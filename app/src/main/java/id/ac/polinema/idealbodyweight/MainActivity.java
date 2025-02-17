package id.ac.polinema.idealbodyweight;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import id.ac.polinema.idealbodyweight.Fragments.AboutFragment;
import id.ac.polinema.idealbodyweight.Fragments.BodyIndexFragment;
import id.ac.polinema.idealbodyweight.Fragments.BrocaIndexFragment;
import id.ac.polinema.idealbodyweight.Fragments.MenuFragment;
import id.ac.polinema.idealbodyweight.Fragments.ResultFragment;

public class MainActivity extends AppCompatActivity implements
		MenuFragment.OnFragmentInteractionListener,
		BrocaIndexFragment.OnFragmentInteractionListener,
BodyIndexFragment.OnFragmentInteractionListener,
		ResultFragment.OnFragmentInteractionListener {

	// Deklarasikan atribut Fragment di sini
	private AboutFragment aboutFragment;
	private BrocaIndexFragment brocaIndexFragment;
	private ResultFragment resultFragment;
	private BodyIndexFragment bodyIndexFragment;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		aboutFragment = AboutFragment.newInstance("Victor Bayu");
		MenuFragment menuFragment = new MenuFragment();
		brocaIndexFragment = new BrocaIndexFragment();
		resultFragment = new ResultFragment();
		bodyIndexFragment = new BodyIndexFragment();
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.fragment_container, menuFragment)
				.commit();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu, menu);
		return  true;
	}

	@Override
	public boolean onOptionsItemSelected(@NonNull MenuItem item) {
		// TODO: Tambahkan penanganan menu di sini
		if(item.getItemId() == R.id.menu_about){
			getSupportFragmentManager().beginTransaction()
					.replace(R.id.fragment_container, aboutFragment)
					.addToBackStack(null)
					.commit();
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onBrocaIndexButtonClicked() {
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.fragment_container, brocaIndexFragment)
				.commit();

	}

	@Override
	public void onBodyMassIndexButtonClicked() {
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.fragment_container, bodyIndexFragment)
				.commit();
	}


	@Override
	public void onCalculateBrocaIndexClicked(float index) {
		resultFragment.setInformation(String.format("Your ideal weight is %.2f kg", index));
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.fragment_container, resultFragment,"broca")
				.commit();
	}
	public void onCalculateBodyMassIndexClicked(String result){
		resultFragment.setInformation(String.format("Your BMI range is " + result));
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.fragment_container,resultFragment, "bmi")
				.commit();
	}

	@Override
	public void onTryAgainButtonClicked(String tag) {
		if (tag.equals("broca")){
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.fragment_container, brocaIndexFragment)
				.commit();
		}else if(tag.equals("bmi"))
		{
			getSupportFragmentManager().beginTransaction()
					.replace(R.id.fragment_container, bodyIndexFragment)
					.commit();
		}
	}

	@Override
	public void onPointerCaptureChanged(boolean hasCapture) {

	}
}
