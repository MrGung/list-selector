(ns foo
  (:require [nbb.core :refer [*file*]]))

(prn *file*) ;; "/private/tmp/foo.cljs"

(defn f [])
(prn (:file (meta #'f))) ;; "/private/tmp/foo.cljs"