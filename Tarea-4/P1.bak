#lang scheme

(define (checkear n lista)
  (cond
    ((= n 0) (null? lista))
    ((null? lista) false)
    (else (checkear (- n 1) (cdr lista)))))
