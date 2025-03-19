package com.seletivo.domain.pessoa;


import com.seletivo.domain.validation.ValidationHandler;
import com.seletivo.domain.validation.Validator;
import  com.seletivo.domain.validation.Error;

public class PessoaValidator extends Validator {

    public static final int NAME_MAX_LENGTH = 200;
    public static final int NAME_MIN_LENGTH = 3;
    private final Pessoa pessoa;

    public PessoaValidator(final Pessoa aPessoa, final ValidationHandler aHandler) {
        super(aHandler);
        this.pessoa = aPessoa;
    }

    @Override
    public void validate() {
        checkNameConstraints();
    }

    private void checkNameConstraints() {
        final var name = this.pessoa.getNome();
        if (name == null) {
            this.validationHandler().append(new Error("'nome' should not be null"));
            return;
        }

        if (name.isBlank()) {
            this.validationHandler().append(new Error("'nome' should not be empty"));
            return;
        }

        final int length = name.trim().length();
        if (length > NAME_MAX_LENGTH || length < NAME_MIN_LENGTH) {
            this.validationHandler().append(new Error("'name' must be between 3 and 200 characters"));
        }
    }
}
