(ns script
  (:require ["csv-parse/lib/sync" :as csv-parse]
            ["fs" :as fs]
            ["shelljs" :as sh]))

(println (count (str (fs/readFileSync "script.cljs"))))

(prn (sh/ls "."))

(prn (csv-parse "foo,bar"))