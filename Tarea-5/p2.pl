cerradura(1,2,3,4,5).

%Resta X e Y y saca el valor absoluto
%y lo guarda en Resultado
diferencia(X,Y,Resultado) :-
    Resta is X-Y,
    Resultado is abs(Resta).

% Llama a diferencia con cada numero que llegan con la cerradura
% y se calcula el promedio. Si el promedio es 0 se encontro la
% contraseña, si el promedio es menor a 1 se esta cerca y si es mayor o
% igual a 1 esta lejos

verificar(X1, X2, X3, X4, X5, R):-
    cerradura(C1, C2, C3, C4, C5),
    diferencia(X1,C1,D1),
    diferencia(X2,C2,D2),
    diferencia(X3,C3,D3),
    diferencia(X4,C4,D4),
    diferencia(X5,C5,D5),
    Promedio is (D1 + D2 + D3 + D4 + D5) * (1 / 5),
    Promedio== 0.0,
    R = "Contraseña descubierta".

verificar(X1, X2, X3, X4, X5, R):-
    cerradura(C1, C2, C3, C4, C5),
    diferencia(X1,C1,D1),
    diferencia(X2,C2,D2),
    diferencia(X3,C3,D3),
    diferencia(X4,C4,D4),
    diferencia(X5,C5,D5),
    Promedio is (D1 + D2 + D3 + D4 + D5) * (1 / 5),
    Promedio < 1,
    R = "Cerca".

verificar(_, _, _, _, _, R) :-
    R = "Lejos".
