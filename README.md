# DynaTech-drake

[![Rama](https://img.shields.io/badge/branch-1.21--latin-2ea44f)](https://github.com/DrakesCraft-Labs/DynaTech-drake/tree/1.21-latin)
[![Licencia](https://img.shields.io/github/license/DrakesCraft-Labs/DynaTech-drake)](https://github.com/DrakesCraft-Labs/DynaTech-drake/blob/1.21-latin/LICENSE)
[![Ultimo commit](https://img.shields.io/github/last-commit/DrakesCraft-Labs/DynaTech-drake/1.21-latin)](https://github.com/DrakesCraft-Labs/DynaTech-drake/commits/1.21-latin)

## Descripción técnica
Addon de Slimefun enfocado en maquinaria avanzada, materiales especiales y cadenas de crafting técnico.

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
| Minecraft | 1.21.x |
| Paper/Purpur | 1.21.x |
| Slimefun Core Drake | 11.x (línea `1.21-latin`) |
| Java | 21 |

## Instalación
1. Descarga el `.jar` de Releases del repositorio.
2. Copia el archivo en la carpeta `plugins/` del servidor.
3. Asegura dependencias (`Slimefun`, `ProtocolLib` u otras según addon).
4. Reinicia el servidor y revisa `logs/latest.log` para validar carga.

## Build local
```bash
mvn -DskipTests clean package
```

Artefacto esperado:
- `target/DynaTech-drake-*.jar`

## Flujo de release
1. Crear branch de cambios (`feature/*` o `fix/*`).
2. Abrir PR hacia `1.21-latin` con plan de pruebas.
3. Al mergear, crear tag/release y publicar jar compilado.

Versionar cambios de recipes/items y registrar compatibilidad con Slimefun core del mismo corte.

## Relación con el monorepo
Este repositorio se mantiene en paralelo con `drakes-slimefun-labs` para desarrollo aislado por addon y despliegues independientes.