(define-struct lst-element (value next))

;; Type: number (list of lst-element) -> (list of lst-element)
;; Returns: a list of lst-element with a new element at the right position
;; inserted in it (so that this element is sorted)
(define (insert value lst)
  (if (or (null? lst) (< value (lst-element-value lst)))
      (make-lst-element value lst)
      (make-lst-element (lst-element-value lst)
                        (insert value (lst-element-next lst)))))

;; Tests
(check-expect (insert 2 (make-lst-element 1 (make-lst-element 3 null)))
	(make-lst-element 1 (make-lst-element 2 (make-lst-element 3 null))))
(check-expect (insert 1 (make-lst-element 2 (make-lst-element 3 null)))
	(make-lst-element 1 (make-lst-element 2 (make-lst-element 3 null))))
(check-expect (insert 1 (make-lst-element 2 (make-lst-element 3 null)))
	(make-lst-element 1 (make-lst-element 2 (make-lst-element 3 null))))

;; Type: (list of lst-element) -> (list of lst-element)
;; Returns: a sorted list of lst-element (via insertion sort)
(define (sort-lst lst)
  (if (null? lst) lst
      (insert (lst-element-value lst)
              (sort-lst (lst-element-next lst)))))

;; Tests
(check-expect (sort-lst (make-lst-element 1 (make-lst-element 2
	(make-lst-element 3 null))))
		(make-lst-element 1 (make-lst-element 2 (make-lst-element 3 null))))
(check-expect (sort-lst (make-lst-element 2 (make-lst-element 1
	(make-lst-element 3 null))))
		(make-lst-element 1 (make-lst-element 2 (make-lst-element 3 null))))
(check-expect (sort-lst (make-lst-element 3 (make-lst-element 2
	(make-lst-element 1 null))))
		(make-lst-element 1 (make-lst-element 2 (make-lst-element 3 null))))