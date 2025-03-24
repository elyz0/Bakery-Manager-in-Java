@ControllerAdvice
public class CustomExceptionHandler {
    
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(IllegalArgumentException.class)
    public ErrorResponse handleRecipeNotFound(IllegalArgumentException ex) {
        return new ErrorResponse("RECIPE_NOT_FOUND", ex.getMessage());
    }
}