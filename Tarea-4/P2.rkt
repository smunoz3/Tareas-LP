#lang scheme

(define (cantidades_simple base funciones)
  (if (null? funciones)
      '()
      (cons ((car funciones) base) (cantidades_simple base (cdr funciones)))))

(define (cantidades_cola base funciones)
  (define (cantidades_2 funciones result)
    (if (null? funciones)
        (reverse result)
        (cantidades_2 (cdr funciones) (cons ((car funciones) base) result))))
  (cantidades_2 funciones '()))
