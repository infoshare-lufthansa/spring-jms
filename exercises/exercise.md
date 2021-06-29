Poniższy system do zarządzania skargami składa się z trzech aplikacji:
 - webapp - przyjmuje skargi od klientów, wysyła je do weryfikacji, a następnie notyfikuje użytkowników o wyniku
 - complaint-verifier (już zaimplementowany) - analizuje skargi klientów i zwraca informację o akceptacji lub braku
 - notifications - zajmuje się wysyłką powiadomień do użytkowników

Zaimplementuj serwis `webapp` tak, aby:
1. Posiadał endpoint POST /api/complaints, który następujące dane:
    - reason - co najmniej znaków, maksymalnie 10
    - amount - tylko liczby większe niż zero
    - email
2. Po otrzymaniu nowej skargi wysłał zapytanie do `complaint-verifier` i oczekiwał na wynik
3. Na podstawie otrzymanego wyniku wyśle do jednej z kolejek (`notification.accepted` lub `notifications.rejected`) wiadomość o rezultacie.

Zaimplementuj serwis `notifications` tak, aby nasłuchiwał na obie kolejki (`notification.accepted` lub `notifications.rejected`) i zależnie od wyniku akcji wypisał odpowiednią wiadomość:
 - success - "Congratulations, your complaint was accepted. Number of complaint: <number>"
 - rejected - "You complaint was rejected.".

TIP: docker run -d -p 5672:5672 -p 15672:15672 rabbitmq:3-management