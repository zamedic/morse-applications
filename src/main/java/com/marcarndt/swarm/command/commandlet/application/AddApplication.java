package com.marcarndt.swarm.command.commandlet.application;

import com.marcarndt.morse.MorseBot;
import com.marcarndt.morse.command.commandlet.Commandlet;
import com.marcarndt.morse.telegrambots.api.objects.Message;
import com.marcarndt.swarm.command.ApplicationCommand;
import java.util.List;
import javax.ejb.Stateless;

/**
 * Created by arndt on 2017/05/03.
 */
@Stateless
public class AddApplication implements Commandlet {

  public static final String addApplicationState = "Add new application";

  @Override
  public boolean canHandleCommand(Message message, String state) {
    return message.getText().equals(ApplicationCommand.applicationCommandState);
  }

  @Override
  public void handleCommand(Message message, String state, List<String> parameters,
      MorseBot morseBot) {
    morseBot.sendReplyMessage(message, "Application Name");
  }

  @Override
  public String getNewState(Message message, String command) {
    return addApplicationState;
  }

  @Override
  public List<String> getNewStateParams(Message message, String state, List<String> parameters) {
    return null;
  }
}
