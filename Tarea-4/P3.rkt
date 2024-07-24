#lang scheme

(define (armar_lista stock)
  ; Función auxiliar para calcular cuántos elementos hay en una lista.
  (define (contar-elementos lista elemento)
    (cond ((null? lista) 0)
          ((equal? (car lista) elemento) (+ 1 (contar-elementos (cdr lista) elemento)))
          (else (contar-elementos (cdr lista) elemento))))

  ; Función principal que procesa la lista de stock y calcula cuánto comprar.
  (define (procesar-stock stock resultado)
    (if (null? stock)
        resultado
        (let* ((par (car stock))
               (cant_necesaria (car par))
               (elemento (cadr par))
               (cant_actual (contar-elementos resultado elemento))
               (cant_comprar (max 0 (- cant_necesaria cant_actual))))
          (procesar-stock (cdr stock) (append resultado (list (list cant_comprar elemento)))))))

  (procesar-stock stock '()))
