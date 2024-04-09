{-# OPTIONS_GHC #-}
import Data.Char ( digitToInt, isNumber )

pushDown :: [Char] -> [Int]
pushDown xs = calcPDA xs []

calcPDA :: [Char] -> [Int] -> [Int]
calcPDA [] ys = ys
calcPDA (x:xs) ys  
            | isNumber x = calcPDA xs (digitToInt x:ys)
            | otherwise = calcPDA xs (doCalc (findOperator x) ys)

doCalc :: (a -> a -> a) -> [a] -> [a]
doCalc f ys =  f (head ys) (ys !! 1) : drop 2 ys

findOperator :: Num a => Char -> a -> a -> a
findOperator f 
            | f == '+' = (+)
            | f == '*' = (*)
