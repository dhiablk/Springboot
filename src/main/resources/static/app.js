const statusEl = document.getElementById('status');
const tableBody = document.querySelector('#productsTable tbody');
const refreshBtn = document.getElementById('refreshBtn');

async function loadProducts() {
    statusEl.textContent = 'Chargement...';
    tableBody.innerHTML = '';

    try {
        const response = await fetch('/api/all');
        if (!response.ok) {
            throw new Error(`Erreur HTTP ${response.status}`);
        }

        const products = await response.json();
        if (!Array.isArray(products) || products.length === 0) {
            statusEl.textContent = 'Aucun produit trouvé.';
            return;
        }

        statusEl.textContent = `${products.length} produit(s) chargés.`;

        const dateFormatter = new Intl.DateTimeFormat('fr-FR', {
            year: 'numeric',
            month: '2-digit',
            day: '2-digit'
        });

        products.forEach((product) => {
            const row = document.createElement('tr');
            const createdAt = product.dateCreation ? dateFormatter.format(new Date(product.dateCreation)) : '-';
            const categoryName = product.categorie?.nomCategorie || '-';
            const supplierName = product.fournisseur?.nomFournisseur || '-';
            const rayonName = product.rayon?.nomRayon || '-';

            row.innerHTML = `
                <td>${product.idProduit ?? '-'}</td>
                <td>${product.nomProduit ?? '-'}</td>
                <td>${product.prixProduit != null ? product.prixProduit.toFixed(2) + ' €' : '-'}</td>
                <td>${createdAt}</td>
                <td>${categoryName}</td>
                <td>${supplierName}</td>
                <td>${rayonName}</td>
            `;

            tableBody.appendChild(row);
        });
    } catch (error) {
        statusEl.textContent = 'Impossible de charger les produits.';
        console.error(error);
    }
}

refreshBtn.addEventListener('click', loadProducts);
window.addEventListener('load', loadProducts);
