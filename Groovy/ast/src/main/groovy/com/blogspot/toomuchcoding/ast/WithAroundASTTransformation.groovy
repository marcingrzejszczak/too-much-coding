package com.blogspot.toomuchcoding.ast
import org.codehaus.groovy.ast.ASTNode
import org.codehaus.groovy.ast.ClassNode
import org.codehaus.groovy.ast.MethodNode
import org.codehaus.groovy.ast.builder.AstBuilder
import org.codehaus.groovy.ast.expr.ArgumentListExpression
import org.codehaus.groovy.ast.expr.ConstantExpression
import org.codehaus.groovy.ast.expr.MethodCallExpression
import org.codehaus.groovy.ast.expr.VariableExpression
import org.codehaus.groovy.ast.stmt.ExpressionStatement
import org.codehaus.groovy.ast.stmt.Statement
import org.codehaus.groovy.control.SourceUnit
import org.codehaus.groovy.transform.ASTTransformation
import org.codehaus.groovy.transform.GroovyASTTransformation

import static org.codehaus.groovy.control.CompilePhase.SEMANTIC_ANALYSIS

@GroovyASTTransformation(phase = SEMANTIC_ANALYSIS)
public class WithAroundASTTransformation implements ASTTransformation {

    public void visit(ASTNode[] nodes, SourceUnit sourceUnit) {
        // get methods from the annotated object
        List methods = sourceUnit.getAST()?.getMethods()
        // find all methods annotated with WithLogging
        methods.findAll { MethodNode method ->
            method.getAnnotations(new ClassNode(WithLogging))
        }.each { MethodNode method ->
            addAstStatementsInAManualWay(method)
            //addAstStatementsWithBuilderFromString(method)
            //addAstStatementsWithBuilderFromCode(method)
            //addAstStatementsWithBuilderFromSpec(method)
        }
    }
    
    // MANUAL
    
    private void addAstStatementsInAManualWay(MethodNode method) {
        Statement startMessage = createPrintlnAst("Starting $method.name")
        Statement endMessage = createPrintlnAst("Ending $method.name")
        addStatements(method, startMessage, endMessage)   
    }

    private Statement createPrintlnAst(String message) {                       
        // create an expression
        return new ExpressionStatement(
                // that executes a method
                new MethodCallExpression(
                        // this.println( ... )
                        new VariableExpression("this"),
                        new ConstantExpression("println"),
                        // that takes message as an argument
                        new ArgumentListExpression(
                                new ConstantExpression(message)
                        )
                )
        )
    }

    // FROM STRING    
    
    private void addAstStatementsWithBuilderFromString(MethodNode method) {
        Statement startMessage = createPrintlnAstWithAstBuilderFromString("Starting $method.name")
        Statement endMessage = createPrintlnAstWithAstBuilderFromString("Ending $method.name")
        addStatements(method, startMessage, endMessage)
    }

    private Statement createPrintlnAstWithAstBuilderFromString(String message) {
        def buildNodes = new AstBuilder().buildFromString(SEMANTIC_ANALYSIS, false, "println(\"$message\")")
        return buildNodes[0].statements[0]
    }
    
    // FROM CODE

    private void addAstStatementsWithBuilderFromCode(MethodNode method) {
        Statement startMessage = createPrintlnAstWithAstBuilderFromCode("Starting $method.name")
        Statement endMessage = createPrintlnAstWithAstBuilderFromCode("Ending $method.name")
        addStatements(method, startMessage, endMessage)
    }

    private Statement createPrintlnAstWithAstBuilderFromCode(String message) {
        def buildNodes = new AstBuilder().buildFromCode(SEMANTIC_ANALYSIS, false, {  
            println message
        })
        return buildNodes[0].statements[0]
    }
    
    
    // FROM SPECIFICATION

    private void addAstStatementsWithBuilderFromSpec(MethodNode method) {
        Statement startMessage = createPrintlnAstWithAstBuilderFromSpec("Starting $method.name")
        Statement endMessage = createPrintlnAstWithAstBuilderFromSpec("Ending $method.name")
        addStatements(method, startMessage, endMessage)
    }

    private Statement createPrintlnAstWithAstBuilderFromSpec(String message) {
        def buildNodes = new AstBuilder().buildFromSpec ({
            methodCall {
                variable "this"
                constant "println"
                argumentList {
                    constant message
                }
            }  
        })
        return new ExpressionStatement(buildNodes[0])
    }

    private void addStatements(MethodNode method, Statement startMessage, Statement endMessage) {
        // Method code consists of statements
        List<ASTNode> existingStatements = method.getCode().getStatements()
        // Start msg at the beginning of the code block
        existingStatements.add(0, startMessage)
        // End msg at the end of the block code
        existingStatements.add(endMessage)
    }
    
}
