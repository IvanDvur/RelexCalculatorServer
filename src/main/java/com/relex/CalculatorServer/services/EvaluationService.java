package com.relex.CalculatorServer.services;

import com.ezylang.evalex.EvaluationException;
import com.ezylang.evalex.Expression;
import com.ezylang.evalex.data.EvaluationValue;
import com.ezylang.evalex.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class EvaluationService {

    Logger log = LoggerFactory.getLogger(EvaluationService.class);

    public String evaluate(String expression) {
        try{
            Expression expression1 = new Expression(expression);
            EvaluationValue result = expression1.evaluate();
            log.info("Успешно вычислено выражение {}. Результат {}",expression,result.getNumberValue());
            System.out.println(result.getNumberValue());
            return result.getNumberValue().toString();
        }catch (EvaluationException e){
            log.error("Не удалось вычислить выражение");
            return "ERROR";
        }catch (ParseException ex){
            log.error("Ошибка парсинга выражения {}",expression);
            return "ERROR";
        }

    }
}
