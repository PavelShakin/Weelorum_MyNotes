package com.mynotes.android.di.modules;

import com.mynotes.core.contracts.dispatchers.ICoroutineDispatchers;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class AppModule_ProvideCoroutineDispatchersFactory implements Factory<ICoroutineDispatchers> {
  private final AppModule module;

  public AppModule_ProvideCoroutineDispatchersFactory(AppModule module) {
    this.module = module;
  }

  @Override
  public ICoroutineDispatchers get() {
    return provideCoroutineDispatchers(module);
  }

  public static AppModule_ProvideCoroutineDispatchersFactory create(AppModule module) {
    return new AppModule_ProvideCoroutineDispatchersFactory(module);
  }

  public static ICoroutineDispatchers provideCoroutineDispatchers(AppModule instance) {
    return Preconditions.checkNotNullFromProvides(instance.provideCoroutineDispatchers());
  }
}
