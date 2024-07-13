package com.billing.Billingsystem.service;

import com.billing.Billingsystem.models.User;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class UserArgumentsProvider implements ArgumentsProvider {
  @Override
  public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
    return Stream.of(
      Arguments.of(User.builder().username("Mayank").password("Minku").build()),
      Arguments.of(User.builder().username("THEONEWHOCAN'TBEDEFEATED").password("PASSWORD1").build())
    );
  }
}
