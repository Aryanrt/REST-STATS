
CREATE TABLE `game` (
  `gameID` int(11) NOT NULL,
  `matchupID` int(11) NOT NULL,
  `date` varchar(20) NOT NULL,
  `location` varchar(50) NOT NULL
);
CREATE TABLE `matchup` (
  `matchupID` int(11) NOT NULL,
  `team1` varchar(3) NOT NULL,
  `team2` varchar(3) NOT NULL
);
CREATE TABLE `player` (
  `playerID` int(11) NOT NULL,
  `teamID` varchar(3) NOT NULL,
  `firstName` varchar(30) NOT NULL,
  `lastName` varchar(30) NOT NULL,
  `position` varchar(2) DEFAULT NULL,
  `pts` double DEFAULT NULL,
  `reb` double DEFAULT NULL,
  `DRB` double DEFAULT NULL,
  `ORB` double DEFAULT NULL,
  `ast` double DEFAULT NULL,
  `stl` double DEFAULT NULL,
  `bs` double DEFAULT NULL,
  `tov` double DEFAULT NULL,
  `FP` double DEFAULT NULL,
  `pf` double DEFAULT NULL,
  `min` double DEFAULT NULL,
  `fga` double DEFAULT NULL,
  `fgm` double DEFAULT NULL,
  `threepa` double DEFAULT NULL,
  `threepm` double DEFAULT NULL,
  `fta` double DEFAULT NULL,
  `ftm` double DEFAULT NULL
);

CREATE TABLE `playerstat` (
  `playerID` int(11) NOT NULL,
  `gameID` int(11) NOT NULL,
  `pts` int(11) DEFAULT NULL,
  `reb` int(11) DEFAULT NULL,
  `ORB` int(11) DEFAULT NULL,
  `DRB` int(11) DEFAULT NULL,
  `ast` int(11) DEFAULT NULL,
  `stl` int(11) DEFAULT NULL,
  `bs` int(11) DEFAULT NULL,
  `tov` int(11) DEFAULT NULL,
  `FP` double NOT NULL,
  `pf` int(11) DEFAULT NULL,
  `pm` int(11) DEFAULT NULL,
  `min` varchar(11) DEFAULT NULL,
  `fga` int(11) DEFAULT NULL,
  `fgm` int(11) DEFAULT NULL,
  `threepa` int(11) DEFAULT NULL,
  `threepm` int(11) DEFAULT NULL,
  `fta` int(11) DEFAULT NULL,
  `ftm` int(11) DEFAULT NULL
);
CREATE TABLE `team` (
  `teamName` varchar(50) NOT NULL,
  `abbriviation` varchar(3) NOT NULL,
  `pts` double DEFAULT NULL,
  `reb` double DEFAULT NULL,
  `DRB` double DEFAULT NULL,
  `ORB` double DEFAULT NULL,
  `ast` double DEFAULT NULL,
  `stl` double DEFAULT NULL,
  `bs` double DEFAULT NULL,
  `tov` double DEFAULT NULL,
  `pf` double DEFAULT NULL,
  `min` double DEFAULT NULL,
  `fga` double DEFAULT NULL,
  `fgm` double DEFAULT NULL,
  `threepa` double DEFAULT NULL,
  `threepm` double DEFAULT NULL,
  `fta` double DEFAULT NULL,
  `ftm` double DEFAULT NULL,
  `PGA` double DEFAULT NULL,
  `SGA` double DEFAULT NULL,
  `SFA` double DEFAULT NULL,
  `PFA` double DEFAULT NULL,
  `CA` double DEFAULT NULL
);
CREATE TABLE `teamstat` (
  `gameID` int(11) NOT NULL,
  `teamID` varchar(3) NOT NULL,
  `pts` int(11) NOT NULL,
  `reb` int(11) NOT NULL,
  `ORB` int(11) DEFAULT NULL,
  `DRB` int(11) DEFAULT NULL,
  `ast` int(11) NOT NULL,
  `stl` int(11) NOT NULL,
  `bs` int(11) NOT NULL,
  `tov` int(11) NOT NULL,
  `pf` int(11) NOT NULL,
  `fga` int(11) NOT NULL,
  `fgm` int(11) NOT NULL,
  `threepa` int(11) NOT NULL,
  `threepm` int(11) NOT NULL,
  `fta` int(11) NOT NULL,
  `ftm` int(11) NOT NULL
);
--
-- Indexes for dumped tables
--

--
-- Indexes for table `game`
--
ALTER TABLE `game`
  ADD PRIMARY KEY (`matchupID`,`date`),
  ADD UNIQUE KEY `gameID` (`gameID`),
  ADD KEY `matchupID` (`matchupID`);

--
-- Indexes for table `matchup`
--
ALTER TABLE `matchup`
  ADD PRIMARY KEY (`matchupID`),
  ADD KEY `team1` (`team1`),
  ADD KEY `team2` (`team2`);

--
-- Indexes for table `player`
--
ALTER TABLE `player`
  ADD PRIMARY KEY (`teamID`,`firstName`,`lastName`),
  ADD UNIQUE KEY `playerID` (`playerID`),
  ADD KEY `teamID` (`teamID`);

--
-- Indexes for table `playerstats`
--
ALTER TABLE `playerstat`
  ADD PRIMARY KEY (`playerID`,`gameID`),
  ADD KEY `gameID` (`gameID`);

--
-- Indexes for table `team`
--
ALTER TABLE `team`
  ADD PRIMARY KEY (`abbriviation`),
  ADD KEY `abbriviation` (`abbriviation`);

--
-- Indexes for table `teamstats`
--
ALTER TABLE `teamstat`
  ADD PRIMARY KEY (`gameID`,`teamID`),
  ADD KEY `teamID` (`teamID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `game`
--
ALTER TABLE `game`
  MODIFY `gameID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2473;
--
-- AUTO_INCREMENT for table `player`
--
ALTER TABLE `player`
  MODIFY `playerID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31157;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `game`
--
ALTER TABLE `game`
  ADD CONSTRAINT `game_ibfk_1` FOREIGN KEY (`matchupID`) REFERENCES `matchup` (`matchupID`);

--
-- Constraints for table `matchup`
--
ALTER TABLE `matchup`
  ADD CONSTRAINT `matchup_ibfk_1` FOREIGN KEY (`team1`) REFERENCES `team` (`abbriviation`),
  ADD CONSTRAINT `matchup_ibfk_2` FOREIGN KEY (`team2`) REFERENCES `team` (`abbriviation`);

--
-- Constraints for table `player`
--
ALTER TABLE `player`
  ADD CONSTRAINT `player_ibfk_1` FOREIGN KEY (`teamID`) REFERENCES `team` (`abbriviation`);

--
-- Constraints for table `playerstat`
--

