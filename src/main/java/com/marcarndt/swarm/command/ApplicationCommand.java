package com.marcarndt.swarm.command;

import com.marcarndt.morse.MorseBot;
import com.marcarndt.morse.command.BaseCommand;
import com.marcarndt.morse.service.UserService;
import com.marcarndt.morse.telegrambots.api.objects.Chat;
import com.marcarndt.morse.telegrambots.api.objects.User;

/**
 * Created by arndt on 2017/06/29.
 */
public class ApplicationCommand extends BaseCommand {

  public static final String addApplication = "Add a new Application";
  public static final String deleteApplication = "Delete a new Application";

  public static final String applicationCommandState = "Manage Application Command";


  @Override
  public String getCommandIdentifier() {
    return "applications";
  }

  @Override
  public String getDescription() {
    return "Add or delete an application.";
  }

  @Override
  public String getRole() {
    return UserService.ADMIN;
  }

  @Override
  protected String performCommand(MorseBot morseBot, User user, Chat chat, String[] arguments) {
    morseBot.sendReplyKeyboardMessage(user, chat, "Select and option", addApplication,
        deleteApplication);
    return applicationCommandState;
  }
}
