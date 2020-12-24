library(plyr)
players <- read.csv("nba_players.csv")
teams <- read.csv("nba_teams.csv")


#1a
three <- players[order(players$X3P, decreasing = TRUE),]
three <- three[1:10,]
three <- three[order(three$X3P),]
barplot(three$X3P, main = "Top 10 Three-point Shooters"
        , names.arg = three$Player, horiz = TRUE, las = 1
        , col = gray.colors(10, rev = TRUE))


#1b
goal <- players[players$FGA > 100,]
hist(goal$FG., breaks = c(0.2, 0.4, 0.5, 0.7)
     , main = "NBA Player Shooting Efficiency", xlab = "%FG"
     , ylab = "Frequency", col = rainbow(3))
legend("topright", legend = c("Poor", "Average", "Great")
       , cex = 0.5, fill = c("red", "green", "blue"))


#1c
nasty <- players[players$Pos == "PG" | players$Pos == "SG" | players$Pos == "SF"
                 | players$Pos == "PF" | players$Pos == "C",]
g <- count(nasty, vars = "Pos")
piepercent <- round(g$freq * 100 / sum(g$freq), digits = 3)
piepercent <- as.character(piepercent)
pie(g$freq, main = "NBA Player Positions", col = rainbow(length(g$Pos))
    , labels = paste(g$Pos, '(', piepercent, '%)'))


#2a
library(arules)
data <- merge(players, teams, by = "Player")
data <- data[data$G > 4,]
data <- data[nchar(data$Team) == 3,]
data <- na.omit(data)

#2b
datas <- split(data$Team, data$Player)

#2c
frequentItemSets <- apriori(datas, parameter = 
                              list(support = 0.08, target = "frequent itemsets"))
inspect(frequentItemSets[1:30])
rules <- ruleInduction(frequentItemSets, confidence = 0.6)
inspect(rules)
