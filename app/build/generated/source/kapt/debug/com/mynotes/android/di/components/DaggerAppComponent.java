package com.mynotes.android.di.components;

import android.app.Application;
import com.mynotes.android.configuration.BaseApplication;
import com.mynotes.android.di.modules.ActivityBuildersModule_ContributeMainActivity;
import com.mynotes.android.screens.base.MainActivity;
import dagger.android.DaggerApplication_MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.DispatchingAndroidInjector_Factory;
import dagger.android.support.DaggerAppCompatActivity_MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;
import java.util.Collections;
import java.util.Map;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class DaggerAppComponent {
  private DaggerAppComponent() {
  }

  public static AppComponent.Builder builder() {
    return new Builder();
  }

  private static final class Builder implements AppComponent.Builder {
    private Application application;

    @Override
    public Builder application(Application application) {
      this.application = Preconditions.checkNotNull(application);
      return this;
    }

    @Override
    public AppComponent build() {
      Preconditions.checkBuilderRequirement(application, Application.class);
      return new AppComponentImpl(application);
    }
  }

  private static final class MainActivitySubcomponentFactory implements ActivityBuildersModule_ContributeMainActivity.MainActivitySubcomponent.Factory {
    private final AppComponentImpl appComponentImpl;

    private MainActivitySubcomponentFactory(AppComponentImpl appComponentImpl) {
      this.appComponentImpl = appComponentImpl;
    }

    @Override
    public ActivityBuildersModule_ContributeMainActivity.MainActivitySubcomponent create(
        MainActivity arg0) {
      Preconditions.checkNotNull(arg0);
      return new MainActivitySubcomponentImpl(appComponentImpl, arg0);
    }
  }

  private static final class MainActivitySubcomponentImpl implements ActivityBuildersModule_ContributeMainActivity.MainActivitySubcomponent {
    private final AppComponentImpl appComponentImpl;

    private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl = this;

    private MainActivitySubcomponentImpl(AppComponentImpl appComponentImpl,
        MainActivity arg0Param) {
      this.appComponentImpl = appComponentImpl;


    }

    @Override
    public void inject(MainActivity arg0) {
      injectMainActivity(arg0);
    }

    private MainActivity injectMainActivity(MainActivity instance) {
      DaggerAppCompatActivity_MembersInjector.injectAndroidInjector(instance, appComponentImpl.dispatchingAndroidInjectorOfObject());
      return instance;
    }
  }

  private static final class AppComponentImpl implements AppComponent {
    private final AppComponentImpl appComponentImpl = this;

    private Provider<ActivityBuildersModule_ContributeMainActivity.MainActivitySubcomponent.Factory> mainActivitySubcomponentFactoryProvider;

    private AppComponentImpl(Application applicationParam) {

      initialize(applicationParam);

    }

    private Map<Class<?>, Provider<dagger.android.AndroidInjector.Factory<?>>> mapOfClassOfAndProviderOfAndroidInjectorFactoryOf(
        ) {
      return Collections.<Class<?>, Provider<dagger.android.AndroidInjector.Factory<?>>>singletonMap(MainActivity.class, ((Provider) mainActivitySubcomponentFactoryProvider));
    }

    private DispatchingAndroidInjector<Object> dispatchingAndroidInjectorOfObject() {
      return DispatchingAndroidInjector_Factory.newInstance(mapOfClassOfAndProviderOfAndroidInjectorFactoryOf(), Collections.<String, Provider<dagger.android.AndroidInjector.Factory<?>>>emptyMap());
    }

    @SuppressWarnings("unchecked")
    private void initialize(final Application applicationParam) {
      this.mainActivitySubcomponentFactoryProvider = new Provider<ActivityBuildersModule_ContributeMainActivity.MainActivitySubcomponent.Factory>() {
        @Override
        public ActivityBuildersModule_ContributeMainActivity.MainActivitySubcomponent.Factory get(
            ) {
          return new MainActivitySubcomponentFactory(appComponentImpl);
        }
      };
    }

    @Override
    public void inject(BaseApplication arg0) {
      injectBaseApplication(arg0);
    }

    private BaseApplication injectBaseApplication(BaseApplication instance) {
      DaggerApplication_MembersInjector.injectAndroidInjector(instance, dispatchingAndroidInjectorOfObject());
      return instance;
    }
  }
}
