# REST API for NBA Statistics
## Deployed to: http://nba-api-aryan.herokuapp.com
### Valid links:
* http://nba-api-aryan.herokuapp.com/teams
* http://nba-api-aryan.herokuapp.com/teams/{teamID}
* http://nba-api-aryan.herokuapp.com/matchups
* http://nba-api-aryan.herokuapp.com/matchups/{matchupID}
* http://nba-api-aryan.herokuapp.com/games
* http://nba-api-aryan.herokuapp.com/games/{gameID}
* http://nba-api-aryan.herokuapp.com/teamstats/{teamID}/{gameID}
* http://nba-api-aryan.herokuapp.com/players
* http://nba-api-aryan.herokuapp.com/players/{playerID}
* http://nba-api-aryan.herokuapp.com/playerstats/{playerID}/{gameID}

#### Note I: Each API endpoint contians numbers of useful(and relevent) hyperlinks, therefore naviagtion through the API should be pretty easy and self explanatory. 
#### Note II: Since the database schema is normalized, for some entities such as PlayerStats, Teamstats,etc. the primary key was chosen to be composite. Therefore multiple(two) paramaters are required to find the entity.
#### Note III: /playerstats and /teamstats were not implemented since the data would be massive and unorganized. 
#### Note IV: For the purpose of this project, POST, PUT and DELETE were not impliminted. The purpose of this project was to provide(not manipulate) NBA stats using REST archituture. 

