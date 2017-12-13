package me.sinisterzek;

import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.Event;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.EventListener;


class DiscordEventHandler implements EventListener {
	// -askme command answers
	private static String[] askme = new String[] {
			// Yes
	        "+ It is certain", "+ It is decidedly so", "+ Without a doubt", "+ Yes, definitely", "+ You may rely on it", "+ As I see it, yes", "+ Most likely", "+ Outlook good", "+ Yes", "+ Signs point to yes",
	        // No
	        "- Don't count on it", "- My reply is no", "- My sources say no", "- Outlook not so good", "- Very doubtful", "- Not likely", "- Definitely not", "- No", "- Signs point to no", "- Certainly not"
	};
public int somethinglol = 0;
	@Override
	public void onEvent(Event baseEvent) {
		// TODO Auto-generated method stub
		if (baseEvent instanceof MessageReceivedEvent) {
			MessageReceivedEvent event = (MessageReceivedEvent) baseEvent;
			// -SAY COMMAND (-say blahblah)
			if (event.getMessage().getContent().startsWith("-say ")) {
				event.getTextChannel().sendMessage(event.getMessage().getContent().substring(5)).complete();
				event.getMessage().addReaction("💬").complete();
			}
			if(true) {
				if (event.getAuthor().isBot()) {
					// do nothing #lol
				} else {
					somethinglol = somethinglol + 1;
				}
			}
			if (event.getMessage().getContent().equals("-amount")) {
				event.getTextChannel().sendMessage("amount = " + somethinglol).complete();
			} else if (event.getMessage().getContent().equals("-claim 10")) {
				somethinglol = somethinglol + 10;
				event.getTextChannel().sendMessage("Successfully added 10 to number. Current total: " + somethinglol).complete();
			} else if (event.getMessage().getContent().equals("-claim 20")) {
				somethinglol = somethinglol + 20;
				event.getTextChannel().sendMessage("Successfully added 20 to number. Current total: " + somethinglol).complete();
			} else if (event.getMessage().getContent().equals("-claim 30")) {
				somethinglol = somethinglol + 30;
				event.getTextChannel().sendMessage("Successfully added 30 to number. Current total: " + somethinglol).complete();
			} else if (event.getMessage().getContent().equals("-claim 40")) {
				somethinglol = somethinglol + 40;
				event.getTextChannel().sendMessage("Successfully added 40 to number. Current total: " + somethinglol).complete();
			} else if (event.getMessage().getContent().equals("-claim 50")) {
				somethinglol = somethinglol + 50;
				event.getTextChannel().sendMessage("Successfully added 50 to number. Current total: " + somethinglol).complete();
			} else if (event.getMessage().getContent().equals("-claim 100")) {
				somethinglol = somethinglol + 100;
				event.getTextChannel().sendMessage("Successfully added 100 to number. Current total: " + somethinglol).complete();
			} else if (event.getMessage().getContent().startsWith("-gamble ")) {
				int a = Integer.parseInt(event.getMessage().getContent().split(" ")[1]);
				event.getMessage().getContent().replace("-gamble ", "");
					if (a > somethinglol) {
					event.getChannel().sendMessage("you can't gamble more than what you have silly!!!! **lolololololololol**").complete();
					event.getMessage().addReaction("✋").complete();
					} else {
						if(Math.random() <= 0.5) {
							somethinglol = somethinglol + a;
							event.getTextChannel().sendMessage("**AYYYYYYYYY** You won " + a + "... wow... now you have " + somethinglol).complete();
							event.getMessage().addReaction("🎉").complete();
						} else {
							somethinglol = somethinglol - a;
							event.getTextChannel().sendMessage("__**rip**__... sowwy- you lost " + a + " now you have " + somethinglol).complete();
							event.getMessage().addReaction("😞").complete();
						}
					}
			}
			// -STOP COMMAND (-stop / -stopbot) (stops bot)
			if (event.getMessage().getContent().equals("-stop")) {
				if (event.getGuild().getMember(event.getAuthor()).hasPermission(Permission.ADMINISTRATOR)) {
					event.getTextChannel().sendMessage("can't stop won't stop... oh wait...").complete();
					event.getMessage().addReaction("✋").complete();
					System.exit(0);
				} else {
					event.getTextChannel().sendMessage("You don't have permission!").complete();
					event.getMessage().addReaction("❌").complete();
				}

			}
			if (event.getMessage().getContent().equals("-stopbot")) {
				if (event.getGuild().getMember(event.getAuthor()).hasPermission(Permission.ADMINISTRATOR)) {
					event.getTextChannel().sendMessage("can't stop won't stop- oh wait...").complete();
					event.getMessage().addReaction("✋").complete();
					System.exit(0);
				} else {
					event.getTextChannel().sendMessage("You don't have permission!").complete();
					event.getMessage().addReaction("❌").complete();
				}

			}
			if (event.getMessage().getContent().equals("-test")) {
				event.getTextChannel().pinMessageById(event.getMessageId()).complete();

			}
			// -ASKME COMMAND (-askme [question]) (8ball generator)
			if (event.getMessage().getContent().startsWith("-askme ")) {
				event.getTextChannel().sendMessage("```diff\n" + askme[(int)(Math.random()*askme.length)] + "\n```").complete();
				event.getMessage().addReaction("🎱").complete();
			} else if (event.getMessage().getContent().equals("-askme")) {
				event.getTextChannel().sendMessage("Go ahead, ask me something! 🎱").complete();
				event.getMessage().addReaction("❌").complete();
			} else if (event.getMessage().getContent().startsWith("-8ball ")) {
				event.getTextChannel().sendMessage("```diff\n" + askme[(int)(Math.random()*askme.length)] + "\n```").complete();
				event.getMessage().addReaction("🎱").complete();
			} else if (event.getMessage().getContent().equals("-8ball")) {
				event.getTextChannel().sendMessage("Go ahead, ask me something! 🎱").complete();
				event.getMessage().addReaction("❌").complete();
			// -WHOAMI COMMAND (-whoami) (mentions you)
			}
			if (event.getMessage().getContent().equals("-whoami")) {
				event.getTextChannel().sendMessage("Hello, " + event.getAuthor().getAsMention()).complete();
				event.getMessage().addReaction("👋").complete();
			}
			if (event.getMessage().getContent().equals("-consoletest")) {
				if (event.getGuild().getMember(event.getAuthor()).hasPermission(Permission.ADMINISTRATOR)) {
					System.out.println("TESTING TESTING 123 ADSASDDASDASDAS");
					event.getMessage().addReaction("🖨").complete();
				} else {
					event.getTextChannel().sendMessage("You don't have permission!").complete();
					event.getMessage().addReaction("❌").complete();
				}
			}
			if (event.getMessage().getContent().equals("-urls")) {
				event.getTextChannel().sendMessage("Server icon - " + event.getGuild().getIconUrl()).complete();
				event.getTextChannel().sendMessage("Your avatar - " + event.getAuthor().getAvatarUrl()).complete();
				event.getMessage().addReaction("📷").complete();
			}
			if (event.getMessage().getContent().equals("-ping")) {
				event.getTextChannel().sendMessage(event.getAuthor().getAsMention() + " Pong!").complete();
				event.getMessage().addReaction("🏓").complete();
			}
			if (event.getMessage().getContent().equals("-dm")) {
				event.getTextChannel().sendMessage(
						event.getAuthor().getAsMention() + " Please mention a user and type a message!").complete();
				event.getMessage().addReaction("❌").complete();
			}
			if (event.getMessage().getContent().startsWith("-dm ")) {
				if (event.getMessage().getMentionedUsers().size() == 0) {
					event.getTextChannel().sendMessage("Mention a user!").complete();
					event.getMessage().addReaction("❌").complete();
				} else {

					String message = event.getMessage().getContent().substring(4);
					for (User u : event.getMessage().getMentionedUsers()) {
						message = message.replaceAll(" @" + u.getName() + " ", " ");
						if (message.endsWith(" @" + u.getName())) {
							message = message.substring(0, message.length() - (" @" + u.getName()).length());
							event.getMessage().addReaction("✅").complete();
						}
						if (message.startsWith("@" + u.getName() + " ")) {
							message = message.substring(("@" + u.getName() + " ").length());
							event.getMessage().addReaction("✅").complete();
						}

					}
					boolean sent = false;
					for (User u : event.getMessage().getMentionedUsers()) {
						if (!u.isBot()) {
							u.openPrivateChannel().complete().sendMessage(message).complete();
						} else {
							if (!sent) {
								sent = true;
								event.getChannel()
										.sendMessage(event.getAuthor().getAsMention() + ", you cannot DM bots!")
										.complete();
								event.getMessage().addReaction("❌").complete();
							}
						}
					}

				}
			}
			// -HELP COMMAND (-help) (helps you)
			if (event.getMessage().getContent().toLowerCase().equals("-help")) {
				event.getTextChannel().sendMessage("**My help command is a work in progress because we're adding new commands** \n  \n__Messaging__ \n  \n• `-say [message]` \n• `-dm [mention] [message]` \n• `-whoami` \n• `-ping` \n• `-emojispam` \n• `-help` \n \n__Moderation__ \n  \n• `-kick [user]` \n• `-ban [user]` \n  \n__Roles__ \n  \n• `-role [mention] [role mention]` \n• `-addrole [mention] [role mention]` \n• `-removerole [mention] [role mention]` \n  \n__Other__ \n  \n• `-stop` \n• `-stopbot` \n• `-dice [1st number] [2nd number]` \n• `-askme [yes ᴏʀ no question]` \n• `-8ball [yes ᴏʀ no question]`").complete();
				event.getMessage().addReaction("📜").complete();
			}
			// -EMOJISPAM COMMAND (spams your message with emojis)
			if (event.getMessage().getContent().equals("-emojispam")) {
				event.getTextChannel().sendMessage("haha").complete();
				event.getMessage().addReaction("😀").complete();
				event.getMessage().addReaction("🤔").complete();
				event.getMessage().addReaction("😂").complete();
				event.getMessage().addReaction("🤣").complete();
				event.getMessage().addReaction("😎").complete();
				event.getMessage().addReaction("🤗").complete();
				event.getMessage().addReaction("🏁").complete();
			}
			if (event.getMessage().getContent().toLowerCase().startsWith("-mute ")) {

				if (event.getGuild().getMember(event.getAuthor()).hasPermission(Permission.MANAGE_ROLES)) {
					if (event.getMessage().getMentionedUsers().size() == 0) {
						event.getTextChannel().sendMessage("Mention a user!").complete();
						event.getMessage().addReaction("❌").complete();
					} else if (event.getMessage().getMentionedRoles().size() == 0) {
						event.getTextChannel().sendMessage("Mention your mute role!").complete();
						event.getMessage().addReaction("❌").complete();
					} else {
						for (Role r : event.getMessage().getMentionedRoles()) {
							for (User u : event.getMessage().getMentionedUsers()) {
								Member m = event.getGuild().getMember(u);
								if (m.getRoles().contains(r)) {
									try {
										event.getGuild().getController().removeRolesFromMember(m, r).complete();
										event.getMessage().addReaction("✅").complete();
										event.getTextChannel().sendMessage("Successfully unmuted " + m.getAsMention() + " from role " + r.getAsMention()).complete();
										u.openPrivateChannel().complete().sendMessage("You've been unmuted in " + event.getGuild().getName() ).complete();
									} catch (Exception e) {

									}
								} else {
									try {
										event.getGuild().getController().addRolesToMember(m, r).complete();
										event.getMessage().addReaction("✅").complete();
										event.getTextChannel().sendMessage("Successfully muted " + m.getAsMention() + " with role " + r.getAsMention()).complete();
										u.openPrivateChannel().complete().sendMessage("You've been muted in " + event.getGuild().getName() ).complete();
									} catch (Exception e) {

									}
								}
							}
						}
					}
				} else {
					event.getTextChannel().sendMessage("You don't have permission!").complete();
					event.getMessage().addReaction("❌").complete();
				}
			}
			// -KICK + -BAN COMMANDS (-kick / -ban [mention]) (kicks/bans users)
			if (event.getMessage().getContent().toLowerCase().startsWith("-kick ")) {

				if (event.getGuild().getMember(event.getAuthor()).hasPermission(Permission.KICK_MEMBERS)) {
					if (event.getMessage().getMentionedUsers().size() == 0) {
						event.getTextChannel().sendMessage("Mention a user!").complete();
						event.getMessage().addReaction("❌").complete();
					} else {
						for (User u : event.getMessage().getMentionedUsers()) {
							Member m = event.getGuild().getMember(u);
							try {
								event.getGuild().getController().kick(m).queue();
								event.getMessage().addReaction("✅").complete();
							} catch (Exception e) {

							}
						}
					}
				} else {
					event.getTextChannel().sendMessage("You don't have permission!").complete();
					event.getMessage().addReaction("❌").complete();
				}
			}
			if (event.getMessage().getContent().toLowerCase().startsWith("-ban ")) {

				if (event.getGuild().getMember(event.getAuthor()).hasPermission(Permission.BAN_MEMBERS)) {
					if (event.getMessage().getMentionedUsers().size() == 0) {
						event.getTextChannel().sendMessage("Mention a user!").complete();
						event.getMessage().addReaction("❌").complete();
					} else {
						for (User u : event.getMessage().getMentionedUsers()) {
							Member m = event.getGuild().getMember(u);
							try {
								event.getGuild().getController().ban(m, 0).queue();
								event.getMessage().addReaction("✅").complete();
							} catch (Exception e) {

							}
						}
					}
				} else {
					event.getTextChannel().sendMessage("You don't have permission!").complete();
					event.getMessage().addReaction("❌").complete();
				}

			}
			// -DICE COMMAND (-dice [number] [number]) (chooses randomly between 2 numbers)
			if (event.getMessage().getContent().equals("-dice")) {
				event.getTextChannel().sendMessage("Please enter two numbers that you want me to roll between. EX- '-dice 1 5'").complete();
				event.getMessage().addReaction("❌").complete();

			} else if (event.getMessage().getContent().toLowerCase().startsWith("-dice ")) {

				int a = Integer.parseInt(event.getMessage().getContent().split(" ")[1]);
				int b = Integer.parseInt(event.getMessage().getContent().split(" ")[2]);

				int x = (int) (Math.random() * (b - a) + a);
				event.getTextChannel().sendMessage("The dice rolled a " + "`" + x + "`!" + " :game_die: ")
						.complete();
				event.getMessage().addReaction("🎲").complete();
			}
			// -ROLE COMMANDS (-role / -addrole / removerole [mention] [role mention]) (adds or removes roles from users)
			if (event.getMessage().getContent().toLowerCase().startsWith("-role ")) {

				if (event.getGuild().getMember(event.getAuthor()).hasPermission(Permission.MANAGE_ROLES)) {
					if (event.getMessage().getMentionedUsers().size() == 0) {
						event.getTextChannel().sendMessage("Mention a user!").complete();
						event.getMessage().addReaction("❌").complete();
					} else if (event.getMessage().getMentionedRoles().size() == 0) {
						event.getTextChannel().sendMessage("Mention a role!").complete();
						event.getMessage().addReaction("❌").complete();
					} else {
						for (Role r : event.getMessage().getMentionedRoles()) {
							for (User u : event.getMessage().getMentionedUsers()) {
								Member m = event.getGuild().getMember(u);
								if (m.getRoles().contains(r)) {
									try {
										event.getGuild().getController().removeRolesFromMember(m, r).complete();
										event.getMessage().addReaction("✅").complete();
										event.getTextChannel().sendMessage("Successfully removed role " + r.getAsMention() + " from " + m.getAsMention()).complete();
									} catch (Exception e) {

									}
								} else {
									try {
										event.getGuild().getController().addRolesToMember(m, r).complete();
										event.getMessage().addReaction("✅").complete();
										event.getTextChannel().sendMessage("Successfully added role " + r.getAsMention() + " to " + m.getAsMention()).complete();
									} catch (Exception e) {

									}
								}
							}
						}
					}
				} else {
					event.getTextChannel().sendMessage("You don't have permission!").complete();
					event.getMessage().addReaction("❌").complete();
				}

			}
			if (event.getMessage().getContent().toLowerCase().startsWith("-addrole ")) {

				if (event.getGuild().getMember(event.getAuthor()).hasPermission(Permission.MANAGE_ROLES)) {
					if (event.getMessage().getMentionedUsers().size() == 0) {
						event.getTextChannel().sendMessage("Mention a user!").complete();
						event.getMessage().addReaction("❌").complete();
					} else if (event.getMessage().getMentionedRoles().size() == 0) {
						event.getTextChannel().sendMessage("Mention a role!").complete();
						event.getMessage().addReaction("❌").complete();
					} else {
						for (Role r : event.getMessage().getMentionedRoles()) {
							for (User u : event.getMessage().getMentionedUsers()) {
								Member m = event.getGuild().getMember(u);
								try {
									event.getGuild().getController().addRolesToMember(m, r).complete();
									event.getMessage().addReaction("✅").complete();
									event.getTextChannel().sendMessage("Successfully added role " + r.getAsMention() + " to " + m.getAsMention()).complete();
								} catch (Exception e) {

								}
							}
						}
					}
				} else {
					event.getTextChannel().sendMessage("You don't have permission!").complete();
					event.getMessage().addReaction("❌").complete();
				}

			}
			if (event.getMessage().getContent().toLowerCase().startsWith("-removerole ")) {

				if (event.getGuild().getMember(event.getAuthor()).hasPermission(Permission.MANAGE_ROLES)) {
					if (event.getMessage().getMentionedUsers().size() == 0) {
						event.getTextChannel().sendMessage("Mention a user!").complete();
						event.getMessage().addReaction("❌").complete();
					} else if (event.getMessage().getMentionedRoles().size() == 0) {
						event.getTextChannel().sendMessage("Mention a role!").complete();
						event.getMessage().addReaction("❌").complete();
					} else {
						for (Role r : event.getMessage().getMentionedRoles()) {
							for (User u : event.getMessage().getMentionedUsers()) {
								Member m = event.getGuild().getMember(u);
								try {
									event.getGuild().getController().removeRolesFromMember(m, r).complete();
									event.getMessage().addReaction("✅").complete();
									event.getTextChannel().sendMessage("Successfully removed role " + r.getAsMention() + " from " + m.getAsMention()).complete();
								} catch (Exception e) {

								}
							}
						}
					}
				} else {
					event.getTextChannel().sendMessage("You don't have permission to perform this command!")
							.complete();
					event.getMessage().addReaction("❌").complete();
				}

			}

		}
	}
}
