package com.mynotes.android.di.modules;

import com.mynotes.android.screens.base.MainActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import javax.annotation.processing.Generated;

@Module(
    subcomponents = ActivityBuildersModule_ContributeMainActivity.MainActivitySubcomponent.class
)
@Generated("dagger.android.processor.AndroidProcessor")
public abstract class ActivityBuildersModule_ContributeMainActivity {
  private ActivityBuildersModule_ContributeMainActivity() {
  }

  @Binds
  @IntoMap
  @ClassKey(MainActivity.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      MainActivitySubcomponent.Factory builder);

  @Subcomponent(
      modules = {
          ViewModelModule.class,
          FragmentBuildersModule.class,
          ViewModelFactoryModule.class
      }
  )
  public interface MainActivitySubcomponent extends AndroidInjector<MainActivity> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<MainActivity> {
    }
  }
}
