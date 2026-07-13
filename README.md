# DynaTech-drake

[![Rama](https://img.shields.io/badge/branch-1.21--latin-2ea44f)](https://github.com/DrakesCraft-Labs/DynaTech-drake/tree/1.21-latin)
[![Licencia](https://img.shields.io/github/license/DrakesCraft-Labs/DynaTech-drake)](https://github.com/DrakesCraft-Labs/DynaTech-drake/blob/1.21-latin/LICENSE)
[![Ultimo commit](https://img.shields.io/github/last-commit/DrakesCraft-Labs/DynaTech-drake/1.21-latin)](https://github.com/DrakesCraft-Labs/DynaTech-drake/commits/1.21-latin)

DynaTech Drake es un addon de Slimefun Drake enfocado en maquinaria avanzada,
materiales especiales y cadenas de crafting técnico.

## Qué añade a Slimefun
- Amplía el árbol tecnológico de Slimefun con nuevos tiers de maquinaria.
- Desbloquea rutas de producción más eficientes.
- Integra contenido técnico adicional para servidores de progresión.

## Características principales
- Nuevos materiales y componentes para producción industrial.
- Máquinas y recipe types avanzados.
- Port alineado a namespaces/dependencias Drake.

## Matriz de compatibilidad
| Componente | Estado |
|---|---|
| Minecraft / Paper / Purpur | **1.21.11** |
| Slimefun Core Drake | **11** (línea `1.21-latin`) |
| Java | 21 |

## Instalación
1. Compila o descarga el JAR de la rama `1.21-latin`.
2. Respalda el JAR y `plugins/DynaTech/` antes de sustituirlo.
3. Instala un único JAR en una ventana de reinicio controlada.
4. Valida en staging una máquina colocada, una receta y su inventario antes de
   continuar con producción.

## Build local
```bash
mvn -B -ntp clean verify
```

Artefacto esperado:
- `target/DynaTech-drake-*.jar`

## Flujo de release
1. Crear branch de cambios (`feature/*` o `fix/*`).
2. Abrir PR hacia `1.21-latin` con plan de pruebas.
3. Al mergear, crear tag/release y publicar jar compilado.

Versionar cambios de recetas/ítems y registrar compatibilidad con el core del
mismo corte. El fork no usa autoactualizadores ni escribe artefactos en
ejecución.

## Relación con el monorepo
Este repositorio es la fuente de desarrollo aislado por addon y despliegues
independientes. Mantiene IDs, recetas y datos de bloque existentes para que una
actualización no invalide progreso de jugadores.
