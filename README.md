# PalaceHomes
Homes Plugin - Commands and GUI
This plugin creates the Home system that can be found in many servers worldwide. 
This plugin is used in GamesPalace, and is copyright! 
What's included?
  - /home command   
  - /sethome command
  - /delhome command
  - Homes GUI
  
 If the command "home" is issued without arguments (home name), a GUI will open and it will list all the homes a player posseses.
 Otherwise, if a home name is provided, the player will be teleported to its location.
 
 Sethome command is meant to add a new home to the player's list. To do so, the player must be in the location of the new home. The command will automatically save its location into a config file. *WARNING: It is not advisible to open the config file and temper with it. Problems might arise and sometimes the only solution will be to reset all homes. Beware!  
 
 Delhome command will remove a home and its location from a player's list. The player need not be in the location so as to perform this command. The only thing they will need is the home's name. *WARNING*: At the present moment, v1.0-SNAPSHOT has a bug which makes the deletion of anything provided as a home name. The implication is that the GUI will not know exactly how many homes the player has, and this will make some of the homes vanish from the GUI.
