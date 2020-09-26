1. Wejdź [tu](https://gluonhq.com/download/javafx-11-0-2-sdk-windows/)
2. Rozpakuj archiwum do `C:\Program Files\Java\`
3. W `Run configuration` w IntelliJ ustaw `VM Options` na  
```--module-path "C:\Program Files\Java\javafx-sdk-11.0.2\lib" --add-modules javafx.controls,javafx.fxml```

Zadanie:
1. Popraw wszystkie `//TODO:` w kodzie
2. Spraw, żeby `ChatController` zamiast dodawać Stringi do pola tekstowego używał metody `sendMessage` z `MessageService`
3. Po wysłaniu wiadomości pobieraj wszystkie wiadomości za pomocą `getMessages` z `MessageService`
4. Utwórz klasę `Message` (zastanów się czy nie będzie potrzebny na nią nowy pakiet) z polami:
    * content
    * created - czas utworzenia
    * author - na tą chwilę String
5. Przerób listę w `MessageService`, tak aby przechowywała `Message`, podobnie w metodzie `sendMessage` od teraz przyjmuj obiekt `Message`
    * przy wysyłaniu wiadomości z `ChatController` autora ustawiaj za pomocą tego co przekazał Nam użytkownik na formatce logowania
    * czas pobieraj z `CurrentTimeService` (później wyjaśni się dlaczego)
6. Stwórz klasę `UserService` z polem `currentUser`, na tą chwilę String.
   * nie zapomnij o setterze i getterze
7. Po kliknieciu przycisku zaloguj (a w wywolaniu sie `loginBtnAction`) ustaw `currentUser` z `UserService` na to co wprowadzil uzytkownik
8. W `ChatController` zamiast pobierac wartosc ustawiona za pomoca `setName` pobieraj wartosc `currentUser` z `UserService`
9. Do formatki logowania dodaj przycisk `Rejestracja` powinien przekierowywac na stage z logowaniem
10. Przekopiuj `chat.fxml` i nazwij go `register.fxml`, usuń z niego wszystkie komponenty poza `Stage`, `Scene` i `VBox`
11. W rejestacji będziemy potrzebowali loginu użytkownika, nicku i dwa razy powtórzonego hasła, utwórz taki formularz
    1. Dodaj kontener `HBox`, do niego dodaj `Label` i `TextField`
    2. Ustaw text `Label` na `login: `
    3. Ustaw `id` dodanego `TextField` na `loginTextField`
    4. Powtórz punkty 1-3 jeszcze dla nicku i podwójnie wprowadzonego hasła
    5. Sprawdź czy formatka ładnie się wyświetla
12. Dodaj ostatni kontener `HBox` i dodaj tam dwa przyciski `Rejestruj` i `Anuluj`
    1. `Rejestruj` powinno na tą chwilę wyświetlać tylko okno dialogowe z informacją "Zarejestrowano: <tutaj nick>"
    2. `Anuluj` powinno pokazywać spowrotem formularz logowania za pomocą `Main.getApplication().showLoginStage() - zaimplementuj na wzór `showChatStage()`
    3. Przed kliknięciem `Rejestruj` przeprowadź walidację pól:
        * login może składać się tylko ze znaków alfanumerycznych, długość przynajmniej 5 znaków
        * hasło musi składać się z conajmniej 7 znaków alfanumerycznych
        * nick może składać się tylko ze znaków alfanumerycznych oraz -@#$, długość przynajmniej 5 znaków
        * Jeśli którakolwiek z walidacji nie przejdzie wyświetl alert z ikonką ostrzeżenia (jak to zrobić znajdziesz [tu](https://code.makery.ch/blog/javafx-dialogs-official/)) i informacją która walidacja nie przeszła
13. Dodajemy integrację z bazą danych, nie rób wszystkiego na raz, bo się nie odkopiesz :)
    1. `Message` od teraz powinno się nazywać `MessageEntity` (pamiętaj o dodaniu niezbędnej dla `Hibernate` kolumny), a `MessageService` powinno korzystać z `MessageDao` do zapisywania i odczytywania wiadomości z bazy danych
    2. Stwórz w odpowiednim pakiecie `UserEntity`, dodaj oprócz obowiązkowej kolumny również `login`, `nick`, `password`
    3. W `UserService` zmień typ pola `currentUser` na `UserEntity`
    4. W `UserService` stwórz metody:
        1. `register(String login, String nick, String password)` do rejestracji użytkownika
        2. `login(String login)` do zalogowania użytkownika (analogicznie jak w zadaniu z pogodynką), pamiętaj o ustawieniu currentUser na aktualnie zalogowanego użytkownika
        * obie powinny korzystać z `UserDao`, żeby wykonywać operację na bazie danych.
    5. Podepnij metodę `register` z `UserService` do metody obsługującej przycisk `Rejestruj`
    6. Podepnij metodę `login` do metody obsługującej przycisk `Zaloguj`
    
    
        
    