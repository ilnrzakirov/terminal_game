# terminal_game

Консольная игра. 

Установка:
1. Из дериктории TerminalGame 
```
mvn install
```

Запуск игры:
1. Из директории TerminalGame:
```
java -jar target/game.jar --enemiesCount=10 --wallsCount=10 --size=30 --profile=production
```
Для изменения режима игры:
```
--enemiesCount=<> - количество врагов
--wallsCount=<> - количество стен
--size=<> - размер карты (30*30);
--profile=production - режим игры (production - обычный режим, dev - режим разработки, подразумевает подверждение хода противника)
```

Для изменения цветой гаммы и символа элементов отредактируйте соответсвующий properties файл в папке resources

![](https://github.com/ilnrzakirov/terminal_game/blob/master/Screen%20Shot%202022-04-24%20at%209.42.08%20AM.png)
