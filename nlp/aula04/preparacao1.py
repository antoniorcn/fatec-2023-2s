from string import punctuation
import nltk

# nltk.download('stopwords')
# nltk.download('portuguese')

texto = """
Provinciano que nunca soube
Escolher bem uma gravata;
Pernambucano a quem repugna
A faca do pernambucano;
Poeta ruim que na arte da prosa
Envelheceu na infância da arte,
E até mesmo escrevendo crônicas
Ficou cronista de província;
Arquiteto falhado, músico
Falhado (engoliu um dia
Um piano, mas o teclado
Ficou de fora); sem família,
Religião ou filosofia;
Mal tendo a inquietação de espírito
Que vem do sobrenatural,
E em matéria de profissão
Um tísico profissional.
"""

especiais = ['\n']
texto_filtrado = ""
for charactere in texto:
    if charactere not in punctuation:
        if charactere in especiais:
            texto_filtrado += ' '
        else:
            texto_filtrado += charactere

tokens = texto_filtrado.split(" ")

stopwords = nltk.corpus.stopwords.words('portuguese')


# print("Tokens: ", tokens)
# print("Stopwords: ", stopwords)

token_sem_stop_words = []

for token in tokens:
    nova_token = token.lower().strip()
    if nova_token != '' and nova_token not in stopwords:
        token_sem_stop_words.append(nova_token)


print(token_sem_stop_words)

