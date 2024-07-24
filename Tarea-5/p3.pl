cerradura(1,2,3,4,5).

comparar(Digito, Digito, 1) :- !.
contar_aciertos(_, _, 0).

verificar(X1, X2, X3, X4, X5, R):-
    cerradura(C1, C2, C3, C4, C5),
    comparar(X1,C1,S1),
    comparar(X2,C2,S2),
    comparar(X3,C3,S3),
    comparar(X4,C4,S4),
    comparar(X5,C5,S5),
    R is S1 + S2 + S3 + S4 + S5,
    (Resultado = 5 -> Resultado = "Contraseña descubierta";true).
