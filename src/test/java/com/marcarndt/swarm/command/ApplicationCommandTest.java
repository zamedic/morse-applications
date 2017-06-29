package com.marcarndt.swarm.command;

import static org.junit.Assert.*;

import com.marcarndt.morse.MorseBot;
import com.marcarndt.morse.service.UserService;
import com.marcarndt.morse.telegrambots.api.objects.Chat;
import com.marcarndt.morse.telegrambots.api.objects.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * Created by arndt on 2017/06/29.
 */
@RunWith(PowerMockRunner.class)
public class ApplicationCommandTest {
  @Mock
  MorseBot morseBot;
  @Mock
  User user;
  @Mock
  Chat chat;

  @InjectMocks
  ApplicationCommand applicationCommand;

  @Test
  public void getCommandIdentifier() {
    assertEquals("applications", applicationCommand.getCommandIdentifier());
  }

  @Test
  public void getDescription() {
    assertEquals("Add or delete an application.", applicationCommand.getDescription());
  }

  @Test
  public void getRole() {
    assertEquals(UserService.ADMIN,applicationCommand.getRole());
  }

  @Test
  public void performCommand()  {
    String response = applicationCommand.performCommand(morseBot,user, chat,null);
    Mockito.verify(morseBot).sendReplyKeyboardMessage(user,chat,"Select and option","Add a new Application","Delete a new Application");
    assertEquals("Manage Application Command",response);
  }

}