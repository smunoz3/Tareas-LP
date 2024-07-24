cifrado([0,0], a).
cifrado([0,1], g).
cifrado([1,0], c).
cifrado([1,1], t).

% Agarra la lista y la separa en 3 partes L1 , L2 y en RestoCifrado
% Luego le pasa L1 y L2 a cifrado y lo guarda en Base y el resto de la
% lista se lo pasa a decifrar de forma recursiva, si decifrar llega
% vacio se detiene y si llega de forma impar falla y retorna false
descifrar([], []).
descifrar([L1, L2 | RestoCifrado], [Base | RestoLetras]) :-
    cifrado([L1, L2], Base), descifrar(RestoCifrado, RestoLetras).
