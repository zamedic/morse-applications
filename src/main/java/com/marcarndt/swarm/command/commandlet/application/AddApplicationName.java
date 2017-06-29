package com.marcarndt.swarm.command.commandlet.application;

import com.marcarndt.morse.MorseBot;
import com.marcarndt.morse.command.commandlet.Commandlet;
import com.marcarndt.morse.telegrambots.api.objects.Message;
import com.marcarndt.swarm.service.ApplicationService;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Created by arndt on 2017/05/03.
 */
@Stateless
public class AddApplicationName implements Commandlet {

  @Inject
  ApplicationService applicationService;


  @Override
  public boolean canHandleCommand(Message message, String state) {
    return state.equals(AddApplication.addApplicationState);
  }

  @Override
  public void handleCommand(Message message, String state, List<String> parameters,
      MorseBot morseBot) {
    String applicationName = message.getText();
    applicationService.addApplication(applicationName);
    morseBot.sendMessage("Added " + applicationName, message.getChatId().toString());
  }

  @Override
  public String getNewState(Message message, String command) {
    return null;
  }

  @Override
  public List<String> getNewStateParams(Message message, String state, List<String> parameters) {
    return null;
  }
}
