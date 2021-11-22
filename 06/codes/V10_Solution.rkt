;; Type: image -> (list of number)
;; Returns: a list with two elements containing the total number of black and white
;; pixel of the given image
(define (count-black-white img)
  (list
   ;; Type: color -> boolean
   ;; Returns: true if the red component of a color is zero 
   (length (filter (lambda (x) (= 0 (color-red x))) (image->color-list img)))
   ;; Type: color -> boolean
   ;; Returns: true if the red component of a color is 255 
   (length (filter (lambda (x) (= 255 (color-red x))) (image->color-list img)))))

;; Type: image -> image
;; Returns: the negative transformation of the given image
(define (negative-transformation img)
  (color-list->bitmap
   (map
    ;; Type: color -> color
    ;; Returns: the negative color of the given color
    (lambda (x)
      (make-color
       (- 255 (color-red x))
       (- 255 (color-green x))
       (- 255 (color-blue x)) 255))
    (image->color-list img))
   (image-width img) (image-height img)))