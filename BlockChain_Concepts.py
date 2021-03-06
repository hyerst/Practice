import hashlib

def hash_function(s):
    b = s.encode()
    return hashlib.sha1(b).hexdigest()

def check_integrity():
    
    for i in range(1, len(blockchain)):
        h1 = blockchain[i-1].compute_hash()
        h2 = blockchain[i].previous_hash
        print('Block %d: %s => %s' % (i-1, h1, 'VALID' if (h1==h2) else 'WRONG'))

class Block():
    
    def __init__(self, previous_hash, transactions):
        self.previous_hash = previous_hash
        self.transactions = transactions
        
    def __repr__(self):
        return self.__dict__.__repr__()
    
    def compute_hash(self):
        return hash_function(self.previous_hash + ('%s' % self.transactions))

b0 = Block(hash_function(''), [])
blockchain = [b0]

#========== Client 1 ========
if (hash_function('') == b0.previous_hash):
    new_transactions = ['Alice gives 20$ to Bob.', 'Bob gives 30$ to Charlie.']
    b1 = Block(b0.compute_hash(), new_transactions)
    blockchain.append(b1)

blockchain[1]

#========== Client 2 =========
if (b0.compute_hash() == b1.previous_hash):
    new_transactions = ['Charlie gives 10$ to Alice.', 'David gives 5$ to Bob.']
    b2 = Block(b1.compute_hash(), new_transactions)
    blockchain.append(b2)

blockchain[2]

#========== Client 3 =========
if (b1.compute_hash() == b2.previous_hash):
    b3 = Block(b2.compute_hash(), ['Alice gives 100$ to David.'])
    blockchain.append(b3)
    
#check_integrity()

#Changing values to teast checker

blockchain[1].transactions[1] = 'Bob gives 30000$ to Eve.'
blockchain[1]

#check_integrity()

#test checker with recompute
new_hash = blockchain[1].compute_hash()
blockchain[2].previous_hash = new_hash

check_integrity() 
