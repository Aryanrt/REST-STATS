# REST API for NBA Statiscis for 2014-15 Season.
## Deployed at: https://nba-api-aryan.herokuapp.com
### Valid links:
* https://nba-api-aryan.herokuapp.com/teams
* https://nba-api-aryan.herokuapp.com/teams/{teamID}
* https://nba-api-aryan.herokuapp.com/matchups
* https://nba-api-aryan.herokuapp.com/matchups/{matchupID}
* https://nba-api-aryan.herokuapp.com/games
* https://nba-api-aryan.herokuapp.com/games/{gameID}
* https://nba-api-aryan.herokuapp.com/teamstats/{teamID}/{gameID}
* https://nba-api-aryan.herokuapp.com/players
* https://nba-api-aryan.herokuapp.com/players/{playerID}
* https://nba-api-aryan.herokuapp.com/playerstats/{playerID}/{gameID}

### Note I: Since the database schema is normalized, for some entities such as PlayerStats, teamstats,etc. the primary key was chosen to be composite.
### Note II: For the purpose of this project, POST, PUT and DELETE were not impliminted. The purpose of this project was to provide(not manipulate) NBA stats using REST archituture. 

